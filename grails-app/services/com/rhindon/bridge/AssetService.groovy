package com.rhindon.bridge

import com.amazonaws.services.s3.model.GetObjectRequest
import grails.gorm.transactions.Transactional

@Transactional
class AssetService {

    def subdomainService

    def amazonS3Service

    def css() {
        amazonS3Service.client.getObject(new GetObjectRequest('assets.bridgeentry.com', "css/${subdomainService.subdomain}.css"))
    }

    def logo() {
        amazonS3Service.client.getObject(new GetObjectRequest('assets.bridgeentry.com', "countylogo/${subdomainService.subdomain}.png"))
    }
}
