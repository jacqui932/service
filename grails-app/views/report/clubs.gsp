<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Club Contacts</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>

    <body>
        <h3 class="text-center">Club Contacts</h3>
        <ul>
            <g:each in="${clubs}" var="club">
                <li style="page-break-inside:avoid;">
                    <span>${club.name} - ${club.address}</span>
                    <table class="table">
                        <thead>
                            <tr>
                                <th width="30%">Name</th>
                                <th width="30%">Email</th>
                                <th width="20%">Tel.No</th>
                                <th width="20%">Role</th>
                            </tr>
                        </thead>
                        <tbody>
                            <g:each in="${club.contacts}" var="contact">
                                <tr>
                                    <td>${contact.name}</td>
                                    <td>${contact.email}</td>
                                    <td>${contact.telephoneNumber}</td>
                                    <td>${contact.role}</td>
                                </tr>
                            </g:each>
                        </tbody>
                    </table>
                </li>
            </g:each>
        </ul>
    </body>
</html>
