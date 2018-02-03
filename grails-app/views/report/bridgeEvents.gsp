<!DOCTYPE html>
<html lang="en">
    <head>
        <title>HBA Events</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>

    <body>
        <div style="border: 5px solid green; background-color: white; padding: 10px 5px">
            <table width="100%">
                <tr width="100%">
                    <td width="15%"><center><img height="150" width="150" class="img-responsive text-center"
                                                 src="http://assets.bridgeentry.com/herts.png"></center></td>
                    <td width="70%">
                        <h1><center><strong>HBA Events</strong></center></h1><br/>
                        <h2><center>February to July 2018</center></h2>
                    </td>
                    <td width="15%" style="text-align: right"><center><img height="150" width="150" class="img-responsive text-center"
                                                                           src="http://assets.bridgeentry.com/ebu.png"></center></td>
                </tr>
            </table>
        </div>
        <div style="padding-top: 30px">
            <g:each in="${events}" var="event">
                <div style="padding-bottom: 5px; page-break-inside:avoid;">
                    <div style="float: left"><h3 style="font-weight: bolder">${event.name}</h3></div>
                    <div style="float: right"><h3>${event.venue.addressLine_1}, <g:formatDate format="d MMMM, h:mm a" date="${event.dateTime}" timeZone="UTC"/></h3></div>
                    <div style="clear: both"><h4>${event.description}</h4></div>
                </div>
            </g:each>
        </div>
        <div style="clear: both; padding-top: 30px; font-size: x-large">
            <center>For more information, please visit <b>http://www.hertsbridge.co.uk</b></center>
        </div>
    </body>
</html>
