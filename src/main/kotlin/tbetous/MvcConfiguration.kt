package tbetous

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
class MvcConfiguration : WebMvcConfigurerAdapter() {

    override fun addViewControllers(registry: ViewControllerRegistry?) {
        super.addViewControllers(registry)
        registry?.addViewController("/home")?.setViewName("home");
        registry?.addViewController("/")?.setViewName("home");
        registry?.addViewController("/hello")?.setViewName("hello");
    }

}