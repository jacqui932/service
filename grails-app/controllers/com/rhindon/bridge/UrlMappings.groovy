package com.rhindon.bridge

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')

        post "/$controller/search(.$format)?"(action: "search")
        post "/$controller/save"(action:"savethis")

        get "/charge/onlineChargeAmount/$id"(controller: "charge", action: "onlineChargeAmount")

        get "/asset/css"(controller: "asset", action: "css")
        get "/asset/logo"(controller: "asset", action: "logo")

        post "/report/monthlyFinancialReport.$format"(controller: "report", action: "monthlyFinancialReport")
        post "/report/bridgeEventsReport.$format"(controller: "report", action: "bridgeEventsReport")
        post "/report/clubsReport.$format"(controller: "report", action: "clubsReport")
        post "/report/heatsReport.$format"(controller: "report", action: "heatsReport")
        post "/report/eventHeatsReport.$format"(controller: "report", action: "eventHeatsReport")
        post "/report/eventPlayersReport.$format"(controller: "report", action: "eventPlayersReport")
        post "/report/victorLudorumReport.$format"(controller: "report", action: "victorLudorumReport")

        post "/website/eventSummaries.($format)?"(controller: "website", action: "eventSummaries")
        post "/website/clubs.($format)?"(controller: "website", action: "clubs")
        post "/website/heats.($format)?"(controller: "website", action: "heats")
    }
}
