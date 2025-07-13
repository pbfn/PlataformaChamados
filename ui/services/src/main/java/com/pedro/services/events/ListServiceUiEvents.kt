package com.pedro.services.events

import com.pedro.services.model.ServiceUI

sealed class ListServiceUiEvents {
    object OnLoadServices : ListServiceUiEvents()
    object OnCreateService : ListServiceUiEvents()
    object OnDismissDialogCreateService : ListServiceUiEvents()
    object OnSaveService : ListServiceUiEvents()
    data class OnChangeStatusService(val serviceUI: ServiceUI) : ListServiceUiEvents()
    data class OnEditService(val serviceUI: ServiceUI) : ListServiceUiEvents()
}