package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;


public class MealServlet extends HttpServlet {
    //private static final Logger LOG = LoggerFactory.getLogger(UserServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        BeanMeals beanMeals = new BeanMeals();
        List<Meal> meal = Arrays.asList(
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );
//        beanMeals.setCalories(500);
//        beanMeals.setDescription("Завтрак");
//        beanMeals.setDateTime(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0));
        List<MealTo> meals = MealsUtil.filteredByStreams(meal,LocalTime.of(0, 0), LocalTime.of(23, 59), 2000);


//        LOG.debug("redirect to User");
        request.setAttribute("meals", meals);
        request.getRequestDispatcher("meals.jsp").forward(request, response);
//        response.sendRedirect("users.jsp");
    }
}
