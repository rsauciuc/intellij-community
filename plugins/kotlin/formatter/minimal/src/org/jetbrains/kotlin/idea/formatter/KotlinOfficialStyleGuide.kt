// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.kotlin.idea.formatter

import com.intellij.openapi.util.NlsContexts
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import org.jetbrains.kotlin.idea.core.formatter.KotlinCodeStyleSettings

object KotlinOfficialStyleGuide {
    const val CODE_STYLE_ID = "KOTLIN_OFFICIAL"
    const val CODE_STYLE_SETTING = "official"
    val CODE_STYLE_TITLE: @NlsContexts.ListItem String
        get() = KotlinFormatterMinimalBundle.message("kotlin.coding.conventions.title")

    fun apply(settings: CodeStyleSettings) {
        applyToKotlinCustomSettings(settings.kotlinCustomSettings)
        applyToCommonSettings(settings.kotlinCommonSettings)
    }

    @JvmStatic
    fun applyToKotlinCustomSettings(
        kotlinCustomSettings: KotlinCodeStyleSettings,
        modifyCodeStyle: Boolean = true
    ) {
        kotlinCustomSettings.apply {
            if (modifyCodeStyle) {
                CODE_STYLE_DEFAULTS = CODE_STYLE_ID
            }

            CONTINUATION_INDENT_IN_PARAMETER_LISTS = false
            CONTINUATION_INDENT_IN_ARGUMENT_LISTS = false
            CONTINUATION_INDENT_FOR_EXPRESSION_BODIES = false
            CONTINUATION_INDENT_FOR_CHAINED_CALLS = false
            CONTINUATION_INDENT_IN_SUPERTYPE_LISTS = false
            CONTINUATION_INDENT_IN_IF_CONDITIONS = false
            CONTINUATION_INDENT_IN_ELVIS = false
            WRAP_EXPRESSION_BODY_FUNCTIONS = CodeStyleSettings.WRAP_AS_NEEDED
            IF_RPAREN_ON_NEW_LINE = true
            ALLOW_TRAILING_COMMA = false
        }
    }

    @JvmStatic
    fun applyToCommonSettings(commonSettings: CommonCodeStyleSettings, modifyCodeStyle: Boolean = true) {
        commonSettings.apply {
            WHILE_ON_NEW_LINE = false
            ELSE_ON_NEW_LINE = false
            CATCH_ON_NEW_LINE = false
            FINALLY_ON_NEW_LINE = false

            CALL_PARAMETERS_WRAP = CodeStyleSettings.WRAP_AS_NEEDED + CodeStyleSettings.WRAP_ON_EVERY_ITEM
            CALL_PARAMETERS_LPAREN_ON_NEXT_LINE = true
            CALL_PARAMETERS_RPAREN_ON_NEXT_LINE = true

            METHOD_PARAMETERS_WRAP = CodeStyleSettings.WRAP_AS_NEEDED + CodeStyleSettings.WRAP_ON_EVERY_ITEM
            METHOD_PARAMETERS_LPAREN_ON_NEXT_LINE = true
            METHOD_PARAMETERS_RPAREN_ON_NEXT_LINE = true

            EXTENDS_LIST_WRAP = CodeStyleSettings.WRAP_AS_NEEDED
            METHOD_CALL_CHAIN_WRAP = CodeStyleSettings.WRAP_AS_NEEDED
            ASSIGNMENT_WRAP = CodeStyleSettings.WRAP_AS_NEEDED

            ALIGN_MULTILINE_BINARY_OPERATION = false
        }

        if (modifyCodeStyle && commonSettings is KotlinCommonCodeStyleSettings) {
            commonSettings.CODE_STYLE_DEFAULTS = CODE_STYLE_ID
        }
    }
}