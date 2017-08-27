package tbetous

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.social.twitter.connect.TwitterConnectionFactory
import org.springframework.social.connect.support.ConnectionFactoryRegistry
import org.springframework.social.connect.ConnectionFactoryLocator
import javax.inject.Inject


@SpringBootApplication
class App : SpringBootServletInitializer()

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}
