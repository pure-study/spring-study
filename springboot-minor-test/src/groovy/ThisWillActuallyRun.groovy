// Run this script this way (after spring-cli installed):
// $ spring run app.groovy
@RestController
class ThisWillActuallyRun {
    @RequestMapping("/")
    String home() {
        "Hello World!"
    }
}
