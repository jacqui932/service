package com.rhindon.bridge

import com.rhindon.bridge.filter.HeatFilter
import com.rhindon.bridge.multitenant.Heat
import grails.rest.RestfulController
import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory

class HeatController extends RestfulController<Heat> {

    static responseFormats = ['json']

    def heatService

    def pairs = '''
        <USEBIO>
            <EVENT EVENT_TYPE="PAIRS">
                <PAIRS>20</PAIRS>
                <NS_PAIRS>10</NS_PAIRS>
                <EW_PAIRS>10</EW_PAIRS>
                <SESSION>
                    <SECTION>
                        <PARTICIPANTS>
                            <PAIR>
                                <PAIR_NUMBER>1A</PAIR_NUMBER> 
                                <DIRECTION>NS</DIRECTION>
                                <PLACE>7</PLACE>
                                <PLAYER>
                                    <PLAYER_NAME>Lena Lewis</PLAYER_NAME>
                                    <NATIONAL_ID_NUMBER>409677</NATIONAL_ID_NUMBER>
                                </PLAYER>
                                <PLAYER>
                                    <PLAYER_NAME>Janne Judd</PLAYER_NAME>
                                    <NATIONAL_ID_NUMBER>487018</NATIONAL_ID_NUMBER>
                                </PLAYER>
                            </PAIR>
                            <PAIR>
                                <PAIR_NUMBER>1A</PAIR_NUMBER>
                                <DIRECTION>NS</DIRECTION>
                                <PLACE>6</PLACE>
                                <PLAYER>
                                    <PLAYER_NAME>Jacqui Collier</PLAYER_NAME>
                                    <NATIONAL_ID_NUMBER>477484</NATIONAL_ID_NUMBER>
                                </PLAYER>
                                <PLAYER>
                                    <PLAYER_NAME>David Collier</PLAYER_NAME>
                                    <NATIONAL_ID_NUMBER>404476</NATIONAL_ID_NUMBER>
                                </PLAYER>
                            </PAIR>
                            <PAIR>
                                <PAIR_NUMBER>1A</PAIR_NUMBER>
                                <DIRECTION>EW</DIRECTION>
                                <PLACE>7</PLACE>
                                <PLAYER>
                                    <PLAYER_NAME>Steve Langridge</PLAYER_NAME>
                                    <NATIONAL_ID_NUMBER>123456</NATIONAL_ID_NUMBER>
                                </PLAYER>
                                <PLAYER>
                                    <PLAYER_NAME>Diana Cook</PLAYER_NAME>
                                    <NATIONAL_ID_NUMBER>654321</NATIONAL_ID_NUMBER>
                                </PLAYER>
                            </PAIR>
                            <PAIR>
                                <PAIR_NUMBER>1A</PAIR_NUMBER>
                                <DIRECTION>EW</DIRECTION>
                                <PLACE>6</PLACE>
                                <PLAYER>
                                    <PLAYER_NAME>Tom Smith</PLAYER_NAME>
                                    <NATIONAL_ID_NUMBER>444444</NATIONAL_ID_NUMBER>
                                </PLAYER>
                                <PLAYER>
                                    <PLAYER_NAME>John Cook</PLAYER_NAME>
                                    <NATIONAL_ID_NUMBER>111111</NATIONAL_ID_NUMBER>
                                </PLAYER>
                            </PAIR>
                        </PARTICIPANTS>
                    </SECTION>
                </SESSION>
            </EVENT>
        </USEBIO>
    '''

    def teams = '''
        <USEBIO>
            <EVENT EVENT_TYPE="TEAMS">
                <SESSION>
                    <PARTICIPANTS>
                        <TEAM>
                            <PLACE>10</PLACE>
                            <PAIR>
                                <PAIR_NUMBER>1-3-4</PAIR_NUMBER>
                                <PLAYER>
                                    <PLAYER_NAME>Lena Lewis</PLAYER_NAME>
                                    <NATIONAL_ID_NUMBER>409677</NATIONAL_ID_NUMBER>
                                </PLAYER>
                                <PLAYER>
                                    <PLAYER_NAME>Janne Judd</PLAYER_NAME>
                                    <NATIONAL_ID_NUMBER>487018</NATIONAL_ID_NUMBER>
                                </PLAYER>
                            </PAIR>
                            <PAIR>
                                <PAIR_NUMBER>2-3-4</PAIR_NUMBER>
                                <PLAYER>
                                    <PLAYER_NAME>Lena Lewis</PLAYER_NAME>
                                    <NATIONAL_ID_NUMBER>409677</NATIONAL_ID_NUMBER>
                                </PLAYER>
                                <PLAYER>
                                    <PLAYER_NAME>Janne Judd</PLAYER_NAME>
                                    <NATIONAL_ID_NUMBER>487018</NATIONAL_ID_NUMBER>
                                </PLAYER>
                            </PAIR>
                        </TEAM>
                    </PARTICIPANTS>
                </SESSION>
            </EVENT>
        </USEBIO>
    '''

    HeatController() {
        super(Heat)
    }

    def search() {
        respond heatService.search(new HeatFilter(request.JSON))
    }

    def upload() {
        def reader = new StringReader(pairs)
        def doc = DOMBuilder.parse(reader)
        def records = doc.documentElement

        use(DOMCategory) {
            records.USEBIO.EVENT
        }
    }
}
