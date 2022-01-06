package com.nassdk.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nassdk.ui.R

val familyConsolas = FontFamily(
    Font(resId = R.font.consolas, weight = FontWeight.Medium)
)

val familyRoboto = FontFamily(
    Font(resId = R.font.roboto_bold, weight = FontWeight.Bold),
    Font(resId = R.font.roboto_medium, weight = FontWeight.Medium),
    Font(resId = R.font.roboto_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(resId = R.font.roboto_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(resId = R.font.roboto_light, weight = FontWeight.Light),
    Font(resId = R.font.roboto_thin, weight = FontWeight.Thin),
)

val familyRubik = FontFamily(
    Font(resId = R.font.rubik_bold, weight = FontWeight.Bold),
    Font(resId = R.font.rubik_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(resId = R.font.rubik_light, weight = FontWeight.Light),
    Font(resId = R.font.rubik_medium, weight = FontWeight.Medium),
    Font(resId = R.font.rubik_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(resId = R.font.rubik_semibold, weight = FontWeight.SemiBold)
)

data class AeroTypography(
    val headerBoldRubik: TextStyle,
    val headerRegRoboto: TextStyle,
    val headerRegCons: TextStyle,
    val bodyRegRoboto: TextStyle,
    val subMedRoboto: TextStyle,
    val buttonMedRoboto: TextStyle,
)

val typography = AeroTypography(
    headerBoldRubik = TextStyle(
        fontSize = text_24,
        fontFamily = familyRubik,
        fontWeight = FontWeight.Bold
    ),
    headerRegCons = TextStyle(
        fontSize = 40.sp,
        fontFamily = familyConsolas,
        fontWeight = FontWeight.Normal
    ),
    headerRegRoboto = TextStyle(
        fontSize = text_20,
        fontFamily = familyRoboto,
        fontWeight = FontWeight.Normal
    ),
    bodyRegRoboto = TextStyle(
        fontSize = text_14,
        fontFamily = familyRoboto,
        fontWeight = FontWeight.Normal
    ),
    subMedRoboto = TextStyle(
        fontSize = text_12,
        fontFamily = familyRoboto,
        fontWeight = FontWeight.Normal
    ),
    buttonMedRoboto = TextStyle(
        fontSize = text_14,
        fontFamily = familyRoboto,
        fontWeight = FontWeight.Normal
    )

)

