package com.umbertoemonds.shoebillmania.features.story.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.umbertoemonds.shoebillmania.R
import com.umbertoemonds.shoebillmania.features.story.presentation.state.StoryUi
import com.umbertoemonds.shoebillmania.features.story.presentation.state.shoebillImages
import kotlin.math.absoluteValue

@Composable
fun ShoebillScreen(stories: MutableList<StoryUi>) {
    val pagerState = rememberPagerState(pageCount = { stories.size + 1 })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 48.dp, bottom = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.padding(top = 60.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Shoebill Mania",
                style = MaterialTheme.typography.headlineLarge,
                fontFamily = FontFamily.Cursive,
                color = Color(0xFF6B5F5F),
            )
            Image(
                modifier = Modifier.height(40.dp),
                painter = painterResource(R.drawable.shoebill_icon),
                contentDescription = ""
            )
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 32.dp),
            pageSpacing = 16.dp,
        ) { page ->
            if(page < stories.size){
                val story = stories[page]
                val imageRes = remember(page) { shoebillImages.random() }

                StoryCard(
                    story = story,
                    imageRes = imageRes,
                    modifier = Modifier.graphicsLayer {
                        val pageOffset = (
                                (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                                ).absoluteValue

                        // alpha = lerp(0.5f, 1f, 1f - pageOffset.coerceIn(0f, 1f))
                        scaleY = lerp(0.9f, 1f, 1f - pageOffset.coerceIn(0f, 1f))

                        shadowElevation = 8.dp.toPx()
                        shape = RoundedCornerShape(24.dp)
                        clip = true
                    }
                )
            } else {
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    Text(
                        modifier = Modifier.padding(start = 22.dp, end = 22.dp),
                        text = "Tu as lu toutes les anecdotes ✨",
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF6B5F5F)
                    )
                }
            }
        }
    }
}

@Composable
fun StoryCard(
    story: StoryUi,
    imageRes: Int,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .wrapContentSize(),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF))
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                color = story.categoryColor,
                shape = RoundedCornerShape(50),
            ) {
                Text(
                    text = story.category,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            StoryImage(
                imageRes = imageRes,
                modifier = Modifier.padding(
                    top = 18.dp,
                    bottom = 18.dp
                )
            )

            Text(
                text = story.story,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                lineHeight = 28.sp
            )
        }
    }
}

@Composable
fun StoryImage(
    imageRes: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = "Illustration de l'anecdote",
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop
    )
}
