package demo;

import demo.resources.TodoInstanceHandlerImpl;
import demowizard.generated.TodoInstance.TodoInstanceResource;
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
    }

}
