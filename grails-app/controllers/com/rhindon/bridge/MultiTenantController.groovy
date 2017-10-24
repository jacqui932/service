package com.rhindon.bridge

import grails.rest.RestfulController

import static grails.gorm.multitenancy.Tenants.withCurrent

abstract class MultiTenantController<T> extends RestfulController<T> {

    MultiTenantController(Class<T> resource) {
        super(resource)
    }

    MultiTenantController(Class<T> resource, boolean readOnly) {
        super(resource, readOnly)
    }

    /**
     * Queries for a resource for the given id
     *
     * @param id The id
     * @return The resource or null if it doesn't exist
     */
    protected T queryForResource(Serializable id) {
        withCurrent { resource.get(id) }
    }

    /**
     * List all of resource based on parameters
     *
     * @return List of resources or empty if it doesn't exist
     */
    protected List<T> listAllResources(Map params) {
        withCurrent { resource.list(params) }
    }

    /**
     * Counts all of resources
     *
     * @return List of resources or empty if it doesn't exist
     */
    protected Integer countResources() {
        withCurrent { resource.count() }
    }

    /**
     * Saves a resource
     *
     * @param resource The resource to be saved
     * @return The saved resource or null if can't save it
     */
    protected T saveResource(T resource) {
        withCurrent { resource.save flush: true }
    }

    /**
     * Deletes a resource
     *
     * @param resource The resource to be deleted
     */
    protected void deleteResource(T resource) {
        withCurrent { resource.delete flush: true }
    }
}
