package com.unirent.config;

import com.unirent.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class DataRestConfig implements RepositoryRestConfigurer {

    private final EntityManager entityManager;
    private String allowedOrigins = "http://localhost:5173";

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] unsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        // disable HTTP methods for Apartment: PUT, POST and DELETE
        disableHttpMethods(Apartment.class, config, unsupportedActions);

        // disable HTTP methods for ApartmentImage: PUT, POST and DELETE
        disableHttpMethods(ApartmentImage.class, config, unsupportedActions);

        // disable HTTP methods for Chat: PUT, POST and DELETE
        disableHttpMethods(Chat.class, config, unsupportedActions);

        // disable HTTP methods for Customer: PUT, POST and DELETE
        disableHttpMethods(Customer.class, config, unsupportedActions);

        // disable HTTP methods for Interest: PUT, POST and DELETE
        disableHttpMethods(Interest.class, config, unsupportedActions);

        // disable HTTP methods for LodgerInterest: PUT, POST and DELETE
        disableHttpMethods(LodgerInterest.class, config, unsupportedActions);

        // disable HTTP methods for Rent: PUT, POST and DELETE
        disableHttpMethods(Rent.class, config, unsupportedActions);

        // expose entity id
        exposedIds(config);

        // configure CORS Mapping
        cors.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(allowedOrigins);
    }

    private static void disableHttpMethods(Class _class, RepositoryRestConfiguration config, HttpMethod[] unsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(_class)
                .withItemExposure(((metadata, httpMethods) -> httpMethods.disable(unsupportedActions)))
                .withCollectionExposure(((metadata, httpMethods) -> httpMethods.disable(unsupportedActions)));
    }

    private void exposedIds(RepositoryRestConfiguration config) {

        // get a list of all entity classes from entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();

        for (EntityType entityType : entities) {
            entityClasses.add(entityType.getJavaType());
        }

        // expose the entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}
