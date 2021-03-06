package com.manning.gia.ssh

import org.gradle.api.DefaultTask
import org.gradle.api.file.FileCollection
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.TaskAction

class Scp extends DefaultTask {
    
    @InputFiles
    FileCollection classpath
    
    @InputFile
    File sourceFile
    
    @Input
    String destination
    
    @Input
    File keyFile
    
    @Input
    Integer port
    
    @TaskAction
    void transferFile() {
        logger.quiet "Copying file '$sourceFile' to server."
        ant.taskdef(name: 'jschScp', classname: 'org.apache.tools.ant.taskdefs.optional.ssh.Scp', classpath: classpath.asPath)
        ant.jschScp(file: sourceFile, todir: destination, keyfile: keyFile.canonicalPath, port: port, trust: 'true')
    }
}