package com.rhindon.bridge.multitenant

import com.rhindon.bridge.Instance
import grails.rest.Resource

@Resource(readOnly = false, formats = ['json'])
class Season {

    Date startDate
    Date endDate
    Instance instance

    static constraints = {
    }
}
