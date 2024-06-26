// "Replace with 'newFun(p1, p2, p3)'" "true"

interface I {
    @Deprecated("", ReplaceWith("newFun(p1, p2, p3)"))
    fun oldFun(p1: String, p2: Int = 0, p3: Int = 1)

    fun newFun(p1: String, p2: Int = 1, p3: Int = 1)
}

abstract class C : I {
    override fun newFun(p1: String, p2: Int, p3: Int) { }

}

fun foo(c: C) {
    c.<caret>oldFun("")
}

// FUS_QUICKFIX_NAME: org.jetbrains.kotlin.idea.quickfix.replaceWith.DeprecatedSymbolUsageFix
// FUS_K2_QUICKFIX_NAME: org.jetbrains.kotlin.idea.k2.codeinsight.fixes.replaceWith.DeprecatedSymbolUsageFix