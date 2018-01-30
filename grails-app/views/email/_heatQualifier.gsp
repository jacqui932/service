<!DOCTYPE html>
<html lang="en">
<body>
<div>
    <div style="border: 5px solid green; background-color: white; padding: 10px 5px">
        <table width="100%">
            <tr width="100%">
                <td width="25%"><img height="75" width="75" class="img-responsive text-center"
                                     src="http://assets.bridgeentry.com/herts.png"></td>
                <td width="50%"><h1><center><strong>Hertfordshire Bridge Association</strong></center></h1></td>
                <td width="25%" style="text-align: right"><img height="75" width="75" class="img-responsive text-center"
                                                               src="http://assets.bridgeentry.com/ebu.png"></td>
            </tr>
        </table>
    </div>

    <div class="col-md-12" style="padding-top: 10px">
        <p>
            Dear ${heatQualifier.name},
        </p>
        <h3>
            Congratulations!
        </h3>
        <p>
            You have qualified for the ${heatQualifier.eventName} due to your great finishing position in the heat at ${heatQualifier.clubName} on ${heatQualifier.heatDate.format('d MMMM yyyy')}.
        </p>
        <p>
            This event will be happening at Bridge Centre, Welwyn Garden City, AL1 2BC on ${heatQualifier.eventDate.format('d MMMM yyyy')}.
        </p>
        <p>
            More details about the event can be found on the <a href="http://www.hertsbridge.co.uk/">Hertforshire Bridge Association web page</a>
        </p>
        <p>
            The entry fee is only &pound;10.00 per pair and <a href="http://herts.bridgeentry.com/#/event/14">an entry form can be found here.</a>
        </p>
        <br/>
        <p>
            We hope to see you at the event,
        </p>
        <p>
            Jacqui and David Collier<br/>HBA Tournament Secretary
        </p>
    </div>
</div>
</body>
</html>
