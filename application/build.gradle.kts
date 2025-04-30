dependencies {
    implementation(project(":common"))
    implementation(project(":authentication"))
    implementation(project(":user"))
    implementation(project(":offer"))
    implementation(project(":user-authentication"))

    implementation("org.springframework.boot:spring-boot-starter")

    implementation("org.springframework.boot:spring-boot-starter-actuator")
    runtimeOnly("org.springframework.modulith:spring-modulith-actuator")
    runtimeOnly("org.springframework.modulith:spring-modulith-observability")

    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
}

tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = true
    mainClass.set("com.review.Application")
}

tasks.named<org.springframework.boot.gradle.tasks.run.BootRun>("bootRun") {
    enabled = true
    mainClass.set("com.review.Application")
}

tasks.named<Jar>("jar") {
    enabled = false
}