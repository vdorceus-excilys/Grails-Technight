package technight.controller

import technight.domaines.Company
import grails.plugin.springsecurity.annotation.Secured

@Secured(["hasRole('ROLE_ADMIN')"])
class CompanyController {

    static scaffold = Company
}
