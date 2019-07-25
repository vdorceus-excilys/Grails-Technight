package technight.domaines

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(["hasRole('ROLE_SIMPLE')"])
class ComputerController {

    ComputerService computerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond computerService.list(params), model:[computerCount: computerService.count()]
    }

    def show(Long id) {
        respond computerService.get(id)
    }

    def create() {
        respond new Computer(params)
    }

    def save(Computer computer) {
        if (computer == null) {
            notFound()
            return
        }

        try {
            computerService.save(computer)
        } catch (ValidationException e) {
            respond computer.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'computer.label', default: 'Computer'), computer.id])
                redirect computer
            }
            '*' { respond computer, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond computerService.get(id)
    }

    def update(Computer computer) {
        if (computer == null) {
            notFound()
            return
        }

        try {
            computerService.save(computer)
        } catch (ValidationException e) {
            respond computer.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'computer.label', default: 'Computer'), computer.id])
                redirect computer
            }
            '*'{ respond computer, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        computerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'computer.label', default: 'Computer'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'computer.label', default: 'Computer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
