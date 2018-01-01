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
        post "/eventEntry/summary(.$format)?"(controller: "eventEntry", action: "summary")

        get "/charge/onlineChargeAmount/$id"(controller: "charge", action: "onlineChargeAmount")

        get "/heat/clubSummaries/$clubId"(controller: "heat", action: "clubSummaries")
        get "/heat/eventSummaries/$eventId"(controller: "heat", action: "eventSummaries")
        get "/heatQualifier/search/$heatId"(controller: "heatQualifier", action: "search")
        get "/heatQualifier/unmatched/$heatId"(controller: "heatQualifier", action: "unmatched")
        post "/heatQualifier/link"(controller: "heatQualifier", action: "link")

        get "/asset/css"(controller: "asset", action: "css")
        get "/asset/logo"(controller: "asset", action: "logo")

        post "/report/monthlyFinancialReport.$format"(controller: "report", action: "monthlyFinancialReport")
        post "/report/bridgeEventsReport.$format"(controller: "report", action: "bridgeEventsReport")
        post "/report/clubsReport.$format"(controller: "report", action: "clubsReport")
        post "/report/heatsReport.$format"(controller: "report", action: "heatsReport")
        post "/report/eventHeatsReport.$format"(controller: "report", action: "eventHeatsReport")
        post "/report/eventPlayersReport.$format"(controller: "report", action: "eventPlayersReport")
        post "/report/victorLudorumReport.$format"(controller: "report", action: "victorLudorumReport")
        post "/report/outstandingPaymentsReport.$format"(controller: "report", action: "outstandingPaymentsReport")
//        post "/report/ecclesCupPointsReport.$format"(controller: "report", action: "ecclesCupPointsReport")

        post "/website/eventSummaries.($format)?"(controller: "website", action: "eventSummaries")
        post "/website/clubs.($format)?"(controller: "website", action: "clubs")
        post "/website/heats.($format)?"(controller: "website", action: "heats")
        get "/website/entries/$id.($format)?"(controller: "website", action: "entries")
        get "/website/event/$id(.$format)?"(controller: "website", action: "event")
        post "/website/entry(.$format)?"(controller: "website", action: "saveEntry")

        post "/website/thankyou"(controller: "website", action: "thankyou")

        get "/player/lookup/$ebuNumber(.$format)?"(controller: "player", action: "lookup")
    }
}
