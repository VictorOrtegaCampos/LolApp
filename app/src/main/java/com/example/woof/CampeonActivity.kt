package com.example.woof

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.woof.data.Campeon

@Composable
fun LolItem(
    campeon: Campeon, modifier: Modifier = Modifier, expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(MaterialTheme.colorScheme.inversePrimary)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                LolIcon(campeon.imagen)
                Row(
                    modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LolInformation(campeon.nombre)
                    LolItemButton(
                        expanded = expanded,
                        onClick = { onExpandedChange(!expanded)},
                    )
                }
            }
            if (expanded) {
                LolHobby(
                    campeon.descripcion, modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
                Habilidades(
                    campeon.pInf,
                    campeon.qInf,
                    campeon.wInf,
                    campeon.eInf,
                    campeon.rInf,
                    campeon.pImg,
                    campeon.qImg,
                    campeon.wImg,
                    campeon.eImg,
                    campeon.rImg
                )

            }
        }
    }
}


@Composable
private fun LolItemButton(
    expanded: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick, modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun LolIcon(
    @DrawableRes imagen: Int, modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = modifier.clip(
                MaterialTheme.shapes.large.copy(
                    bottomStart = CornerSize(0.dp), bottomEnd = CornerSize(0.dp)
                )
            ),

            contentScale = ContentScale.Crop,
            painter = painterResource(imagen),
            contentDescription = null
        )
    }

}


@Composable
fun LolInformation(
    @StringRes champName: Int
) {
    Text(
        text = stringResource(champName),
        style = MaterialTheme.typography.displayLarge,


        )
}

@Composable
fun LolHobby(
    @StringRes lolDescription: Int, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(lolDescription), style = MaterialTheme.typography.displayMedium
        )
    }
}

@Composable
fun ImageResource(
    @DrawableRes resourceId: Int,
    modifier: Modifier = Modifier,
    contentDescription: String?,
    onClick: () -> Unit,
    isSelected: Boolean
) {
    val alpha = if (isSelected) 1.0f else 0.5f

    Image(
        painter = painterResource(resourceId),
        contentDescription = contentDescription,
        modifier = modifier
            .padding(8.dp)
            .clip(MaterialTheme.shapes.large.copy())
            .size(60.dp)
            .clickable(onClick = onClick)
            .graphicsLayer(alpha = alpha)
    )
}


@Composable
fun Habilidades(
    pInf: Int,
    qInf: Int,
    wInf: Int,
    eInf: Int,
    rInf: Int,
    pImg: Int,
    qImg: Int,
    wImg: Int,
    eImg: Int,
    rImg: Int
) {
    var selectedImage by remember { mutableStateOf(pImg) }

    val p = stringResource(id = pInf)
    val q = stringResource(id = qInf)
    val w = stringResource(id = wInf)
    val e = stringResource(id = eInf)
    val r = stringResource(id = rInf)

    Column {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            ImageResource(
                resourceId = pImg,
                contentDescription = null,
                onClick = {
                    selectedImage = pImg
                },
                isSelected = selectedImage == pImg
            )
            ImageResource(
                resourceId = qImg,
                contentDescription = null,
                onClick = {
                    selectedImage = qImg
                },
                isSelected = selectedImage == qImg
            )
            ImageResource(
                resourceId = wImg,
                contentDescription = null,
                onClick = {
                    selectedImage = wImg
                },
                isSelected = selectedImage == wImg
            )
            ImageResource(
                resourceId = eImg,
                contentDescription = null,
                onClick = {
                    selectedImage = eImg
                },
                isSelected = selectedImage == eImg
            )
            ImageResource(
                resourceId = rImg,
                contentDescription = null,
                onClick = {
                    selectedImage = rImg
                },
                isSelected = selectedImage == rImg
            )
        }
        Text(
            text = when (selectedImage) {
                pImg -> p
                qImg -> q
                wImg -> w
                eImg -> e
                rImg -> r
                else -> ""
            },
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
            style = MaterialTheme.typography.bodyLarge

        )
    }
}

@Composable
fun Carta(campeon: Campeon, modifier: Modifier) {
    var rotated by remember { mutableStateOf(false) }
    val rotar by animateFloatAsState(
        targetValue = if (rotated) 360f else 0f,
        animationSpec = tween(600), label = ""
    )

    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .padding(8.dp)
            .graphicsLayer {
                rotationY = rotar
                cameraDistance = 8 * density
            }
            .clickable { rotated = !rotated }
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.inversePrimary)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            if (!rotated) {
                LolItem(campeon,modifier,expanded){
                    expanded = it
                }
            } else {
                CartaDetras(campeon, campeon.skinNombre, campeon.skinFoto, modifier, expanded) {
                    expanded = it
                }
            }
        }
    }
}

@Composable
fun CartaDetras(
    campeon: Campeon,
    @StringRes skinName: Int,
    @DrawableRes skinImagen: Int,
    modifier: Modifier,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = modifier.clip(
                MaterialTheme.shapes.large.copy(
                    bottomStart = CornerSize(0.dp), bottomEnd = CornerSize(0.dp)
                )
            ),

            contentScale = ContentScale.Crop,
            painter = painterResource(skinImagen),
            contentDescription = null
        )
        Row(
            modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(skinName),
                style = MaterialTheme.typography.displayLarge,
            )
            LolItemButton(
                expanded = expanded,
                onClick = { onExpandedChange(!expanded)},
            )
        }
    }

    if (expanded) {
        LolHobby(
            campeon.descripcion, modifier = Modifier.padding(
                start = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(R.dimen.padding_small),
                end = dimensionResource(R.dimen.padding_medium),
                bottom = dimensionResource(R.dimen.padding_medium)
            )
        )
        Habilidades(
            campeon.pInf,
            campeon.qInf,
            campeon.wInf,
            campeon.eInf,
            campeon.rInf,
            campeon.pImg,
            campeon.qImg,
            campeon.wImg,
            campeon.eImg,
            campeon.rImg
        )

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LolTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,

                ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size)),
                    painter = painterResource(R.drawable.lol_logo),

                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .size(180.dp),
                    painter = painterResource(R.drawable.league_of_legends__1_),

                    contentDescription = null
                )

            }
        },
    )
}