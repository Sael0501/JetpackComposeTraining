package com.example.jetpackcomposetraining.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintExample() {
    ConstraintLayout(Modifier.fillMaxSize()) {

        val (box1, box2, box3, box4, box5) = createRefs()
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Blue)
                .constrainAs(box2) {
                    end.linkTo(box1.start)
                    bottom.linkTo(box1.top)
                }
        )
        Box(
            Modifier
                .size(125.dp)
                .background(Color.DarkGray)
                .constrainAs(box3) {
                    start.linkTo(box1.end)
                    bottom.linkTo(box1.top)
                }
        )
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Black)
                .constrainAs(box4) {
                    top.linkTo(box1.bottom)
                    end.linkTo(box1.start)
                }
        )
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Green)
                .constrainAs(box5) {
                    start.linkTo(box1.end)
                    top.linkTo(box1.bottom)
                }
        )
    }
}


@Composable
fun ConstraintGuideLineExample() {
    ConstraintLayout(Modifier.fillMaxSize()) {

        val greenBox = createRef()
        val topGuideLine = createGuidelineFromTop(0.1f)
        val startGuideLine = createGuidelineFromStart(0.1f)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(greenBox) {
                top.linkTo(topGuideLine)
                start.linkTo(startGuideLine)
            })
    }
}

@Composable
fun ConstraintBarrierExample() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (box1, box2, box3) = createRefs()
        val barrier = createEndBarrier(box1, box2)

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )
        Box(
            Modifier
                .size(235.dp)
                .background(Color.Blue)
                .constrainAs(box2) {
                    top.linkTo(box1.bottom)
                    start.linkTo(parent.start, margin = 32.dp)
                }
        )
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(box3) {
                start.linkTo(barrier)
            })
    }
}

@Preview
@Composable
fun ConstrainChainExample(){
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (box1, box2, box3) = createRefs()

        Box(
            Modifier
                .size(75.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    start.linkTo(parent.start)
                    end.linkTo(box2.start)
                }
        )
        Box(
            Modifier
                .size(75.dp)
                .background(Color.Blue)
                .constrainAs(box2) {
                    start.linkTo(box1.end)
                    end.linkTo(box3.start)
                }
        )
        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Yellow)
            .constrainAs(box3) {
                start.linkTo(box2.end)
                end.linkTo(parent.end)
            })

        createHorizontalChain(box1, box2, box3, chainStyle = ChainStyle.SpreadInside)
    }
}
