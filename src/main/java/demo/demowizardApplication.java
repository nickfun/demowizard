package demo;

import demo.db.TodoDb;
import demo.resources.TodoInstanceHandlerImpl;
import demo.resources.TodoListHandlerImpl;
import demowizard.generated.TodoInstance.TodoInstanceResource;
import demowizard.generated.TodoList.TodoListResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
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
        bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
                bootstrap.getConfigurationSourceProvider(),
                new EnvironmentVariableSubstitutor(true)));
    }

    @Override
    public void run(final demowizardConfiguration configuration,
                    final Environment environment) {

        TodoDb database = new TodoDb();
        environment.jersey().register(new TodoInstanceResource(new TodoInstanceHandlerImpl(database)));
        environment.jersey().register(new TodoListResource(new TodoListHandlerImpl(database)));
    }

}
