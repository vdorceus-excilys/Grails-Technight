package technight.domaines

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ComputerServiceSpec extends Specification {

    ComputerService computerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Computer(...).save(flush: true, failOnError: true)
        //new Computer(...).save(flush: true, failOnError: true)
        //Computer computer = new Computer(...).save(flush: true, failOnError: true)
        //new Computer(...).save(flush: true, failOnError: true)
        //new Computer(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //computer.id
    }

    void "test get"() {
        setupData()

        expect:
        computerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Computer> computerList = computerService.list(max: 2, offset: 2)

        then:
        computerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        computerService.count() == 5
    }

    void "test delete"() {
        Long computerId = setupData()

        expect:
        computerService.count() == 5

        when:
        computerService.delete(computerId)
        sessionFactory.currentSession.flush()

        then:
        computerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Computer computer = new Computer()
        computerService.save(computer)

        then:
        computer.id != null
    }
}
