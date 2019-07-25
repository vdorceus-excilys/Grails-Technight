package technight

import technight.domaines.Computer;
import technight.domaines.Company;
class BootStrap {

    def init = { servletContext ->
        
        def companies = []
        Company asus = new Company(name: 'ASUS')
        companies.add(asus)
        Company dell = new Company(name: 'DELL')
        companies.add(asus)
        
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

    }
    def destroy = {
    }
}
