<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>
<content tag="nav">
<sec:ifLoggedIn>
<g:link controller="logout" >Logout</g:link>
</sec:ifLoggedIn>
<sec:ifNotLoggedIn>
<g:link controller="login" action="auth">Login</g:link>
</sec:ifNotLoggedIn>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manage <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><g:link controller="computer"> Computer</g:link></li>
            <li class="dropdown-item"><g:link controller="company">Company</g:link></li>
        </ul>
    </li>
</content>

<div class="svg" role="presentation">
    <div class="grails-logo-container">
        <asset:image src="excilys.png" class="grails-logo"/>
    </div>
</div>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Bienvenue à la TechNight de GRAILS.</h1>

       

    </section>
</div>

</body>
</html>
