package technight.domaines

import grails.gorm.services.Service

@Service(Computer)
interface ComputerService {

    Computer get(Serializable id)

    List<Computer> list(Map args)

    Long count()

    void delete(Serializable id)

    Computer save(Computer computer)

}