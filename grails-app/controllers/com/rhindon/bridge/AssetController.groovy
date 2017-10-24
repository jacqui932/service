package com.rhindon.bridge

import com.amazonaws.util.IOUtils

class AssetController {

    def assetService

    def css() {
        response.contentType = 'text/css'
        response.outputStream << IOUtils.toByteArray(assetService.css().getObjectContent())
    }

    def logo() {
        response.contentType = 'image/png'
        response.outputStream << IOUtils.toByteArray(assetService.logo().getObjectContent())
    }
}
