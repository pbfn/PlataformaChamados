package com.pedro.plataformachamados.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

interface InvoiceResourceStrategy {
    fun getPrimaryColor(): Color
    fun getInvoiceButtons(): InvoiceButtonsModelData = InvoiceButtonsModelData()
}

data class InvoiceButtonsModelData(
    val showButtonAdvancePayment: Boolean = false,
)


class GetDefaultInvoiceStrategy() : InvoiceResourceStrategy {
    override fun getPrimaryColor(): Color {
        TODO("Not yet implemented")
    }

    override fun getInvoiceButtons(): InvoiceButtonsModelData =
        InvoiceButtonsModelData(showButtonAdvancePayment = true)
}

class GetOpenInvoiceStrategy() : InvoiceResourceStrategy {
    override fun getPrimaryColor(): Color {
        TODO("Not yet implemented")
    }

    override fun getInvoiceButtons(): InvoiceButtonsModelData =
        InvoiceButtonsModelData(showButtonAdvancePayment = false)
}

@Composable
fun Screen(modifier: Modifier = Modifier, invoiceStrategy: InvoiceResourceStrategy) {

}
