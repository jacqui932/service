package com.rhindon.bridge

import grails.gorm.transactions.Transactional
import org.springframework.web.context.request.RequestAttributes
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletWebRequest

import javax.servlet.http.HttpServletRequest

@Transactional
class SubdomainService {

    def getSubdomain() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes()
        if(requestAttributes instanceof ServletWebRequest) {
            HttpServletRequest httpServletRequest = ((ServletWebRequest) requestAttributes).getRequest()
            URI subdomainUri = new URI(httpServletRequest.getHeaders('Origin').nextElement())
            String[] tokenized = subdomainUri.host.tokenize('.')
            return (tokenized[0] == 'admin') ? tokenized[1] : tokenized[0]
        }
        throw new IllegalArgumentException("Must be called in the context of a web request")
    }
}
