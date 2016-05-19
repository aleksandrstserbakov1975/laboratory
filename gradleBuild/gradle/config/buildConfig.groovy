environments {
    local {
        server {
            hostname = "localhost"
            sshPort = 2222
            username = "vagrant"
        }
        tomcat {
            hostname = "192.168.1.33"
            port = 8080
            context = "todo"
        }
    }
}