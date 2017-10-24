package com.rhindon.bridge

import org.grails.datastore.mapping.core.connections.ConnectionSource
import org.grails.datastore.mapping.multitenancy.AllTenantsResolver
import org.grails.datastore.mapping.multitenancy.TenantResolver
import org.springframework.web.context.request.RequestAttributes
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletWebRequest

import javax.servlet.http.HttpServletRequest

class SubDomainTenantResolver implements TenantResolver, AllTenantsResolver {

    @Override
    Serializable resolveTenantIdentifier() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes()
        if(requestAttributes instanceof ServletWebRequest) {
            HttpServletRequest httpServletRequest = ((ServletWebRequest) requestAttributes).getRequest()
            URI subdomainUri = new URI(httpServletRequest.getHeaders('Origin').nextElement())
            String[] tokenized = subdomainUri.host.tokenize('.')
            return (tokenized[0] == 'admin') ? tokenized[1] : tokenized[0]
        }
        return ConnectionSource.DEFAULT
    }

    @Override
    Iterable<Serializable> resolveTenantIds() {
        return ['herts', 'demo']
    }
}
