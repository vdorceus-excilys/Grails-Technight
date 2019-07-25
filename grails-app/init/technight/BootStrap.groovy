package technight

import technight.domaines.Computer;
import technight.domaines.Company;
import technight.security.User;
import technight.security.UserRole;
import technight.security.Role;
class BootStrap {

    def init = { servletContext ->
        
        def companies = []
        Company asus = new Company(name: 'ASUS')
        companies.add(asus)
        Company dell = new Company(name: 'DELL')
        companies.add(dell)
        
        companies.each {company -> company.save(flush: true, failOnError:true)}

        def computers = []
        Computer rog = new Computer(name: 'Republic OF Gaming', company: asus);
        computers.add(rog)
        Computer vivo = new Computer(name: 'Vivo Book', company: asus)
        computers.add(vivo)
        Computer latitude = new Computer(name: 'Latitude', company: dell)
        computers.add(latitude)
        Computer xps = new Computer(name: 'XPS', company: dell)
        computers.add(xps)

        computers.each { computer -> computer.save( flush: true, failOnError: true) }

        def simpleUser = new User(username: 'simple', password: '12345678')
        def adminUser = new User(username: 'admin', password: '12345678')
       
        def simpleRole= new Role(authority: 'ROLE_SIMPLE')
        def adminRole = new Role(authority: 'ROLE_ADMIN')

        simpleUser.save(flush:true, failOnError:true)
        adminUser.save(flush:true, failOnError:true)
        simpleRole.save(flush:true, failOnError:true)
        adminRole.save(flush:true, failOnError:true)

        UserRole.create(simpleUser, simpleRole, true)
        UserRole.create(adminUser, simpleRole, true)
        UserRole.create(adminUser, adminRole, true)

    }
    def destroy = {
    }
}
