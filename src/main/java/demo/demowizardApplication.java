package demo;

import demo.resources.TodoInstanceHandlerImpl;
import demo.resources.TodoListHandlerImpl;
import demowizard.generated.TodoInstance.TodoInstanceResource;
import demowizard.generated.TodoList.TodoListResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class demowizardApplication extends Application<demowizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new demowizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "demowizard";
    }

    @Override
    public void initialize(final Bootstrap<demowizardConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final demowizardConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new TodoInstanceResource(new TodoInstanceHandlerImpl()));
        environment.jersey().register(new TodoListResource(new TodoListHandlerImpl()));
    }

}
