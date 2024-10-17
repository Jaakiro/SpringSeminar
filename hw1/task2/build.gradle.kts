plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.tomcat.embed:tomcat-embed-core:9.0.71")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:9.0.71")
    implementation("org.apache.tomcat.embed:tomcat-embed-websocket:9.0.71")
}

application {
    mainClass.set("com.example.TomcatServer")
}
