package controllers;

import org.apache.commons.text.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import play.mvc.*;
import repository.EmployeeRepository;
import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests.
 */
public class HomeController extends Controller {

    private final EmployeeRepository employeeRepository;

    @Inject
    public HomeController(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Result index() {
        return ok(views.html.index.render());
    }

    public Result hello(final String name) {
        final Document document = Jsoup.parse(views.html.hello.render().body());
        document.body().append("<h2>Your name is " + name + "</h2>");

        return ok(document.html()).as("text/html");
    }

    public Result helloSecured(final String name) {
        final Document document = Jsoup.parse(views.html.hello.render().body());
        final String nameEscaped = StringEscapeUtils.escapeHtml4(name);

        document.body().append("<h2>Your name is " + nameEscaped + "</h2>");

        return ok(document.html()).as("text/html");
    }

    public Result getEmployeeById(final String id) {
        return ok(views.html.employee.render(employeeRepository.getById(id)));
    }

    public Result getEmployeeByIdSecured(final String id) {
        return ok(views.html.employee.render(employeeRepository.getByIdSecured(id)));
    }

}
