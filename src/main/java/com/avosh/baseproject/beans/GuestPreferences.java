/*******************************************************************************
 * Created by Alireza Amirkhani 2022
 ******************************************************************************/
package com.avosh.baseproject.beans;

import com.avosh.baseproject.util.Empty;
import org.springframework.context.annotation.Scope;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.*;

@Component
@Scope("session")
public class GuestPreferences implements Serializable {

    public String locale;
    LinkedHashMap<String, Object> countries;
    private String captchaLocal;

    private String theme = "blue";

    private String layout = "light";

    private String menuMode = "menu-layout-static";

    private String inputStyle = "outlined";

    private String menuColor = "dark";

    private List<Theme> themes;

    private List<Layout> layouts;

    private String themePath;

    @PostConstruct
    public void init() {

        layouts = new ArrayList<>();
        layouts.add(new Layout("Light", "light", "#ffffff"));

        countries = new LinkedHashMap<String, Object>();
        countries.put("English", Locale.ENGLISH);
        countries.put("Farsi", (new Locale("fa")));


        if (FacesContext.getCurrentInstance()
                .getViewRoot().getLocale().equals("fa")) {
            themePath = "custom-rtl.css";
            LocaleContextHolder.setLocale(new Locale("fa"));
            FacesContext.getCurrentInstance()
                    .getViewRoot().setLocale(new Locale("fa"));
        } else {
            themePath = "custom-ltr.css";
        }
        readLocaleCodeFromCookie();
    }


    public void changeLanguage(ValueChangeEvent e) {
        String newLocaleValue = e.getNewValue().toString();
        for (Map.Entry<String, Object> entry : countries.entrySet()) {

            if (entry.getValue().toString().equals(newLocaleValue)) {
                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale((Locale) entry.getValue());
                if (newLocaleValue.equals("fa")) {
                    themePath = "custom-rtl.css";
                    captchaLocal = locale = "fa";
                    LocaleContextHolder.setLocale(new Locale("fa"));
                    FacesContext.getCurrentInstance()
                            .getViewRoot().setLocale(new Locale("fa"));
                } else {
                    LocaleContextHolder.setLocale(new Locale("en"));
                    themePath = "custom-ltr.css";
                    captchaLocal = locale = "en";
                }
                writeLocaleCodeToCookie(locale);
            }
        }
    }

    public String getThemePath() {
        if (Empty.isNotEmpty(locale)) {
            if (locale.equals("fa")) {
                themePath = "custom-rtl.css";
                captchaLocal = "fa";
                LocaleContextHolder.setLocale(new Locale("fa"));
                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale(new Locale("fa"));
            }
        }
        return themePath;
    }

    private void writeLocaleCodeToCookie(String locale) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        Cookie cookie = new Cookie("lang", locale);
        cookie.setMaxAge(259200);
        cookie.setPath("/");
        response.addCookie(cookie);


    }

    private void readLocaleCodeFromCookie() {
        Boolean isCookieExist = false;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        Cookie[] cookies = request.getCookies();
        if (Empty.isNotEmpty(cookies)) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("lang")) {
                    captchaLocal = locale = cookie.getValue();
                    isCookieExist = true;
//                    cookie.setMaxAge(0);
//                    response.addCookie(cookie);
                }
            }
        }
        if (!isCookieExist) {
            if (Empty.isEmpty(locale)) {
                locale = "en";
            }
            Cookie cookie = new Cookie("lang", locale);
            cookie.setMaxAge(259200);
            cookie.setPath("/");
            response.addCookie(cookie);
        }

    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getMenuMode() {
        return menuMode;
    }

    public void setMenuMode(String menuMode) {
        this.menuMode = menuMode;
    }

    public String getInputStyleClass() {
        return this.inputStyle.equals("filled") ? "ui-input-filled" : "";
    }

    public String getInputStyle() {
        return inputStyle;
    }

    public void setInputStyle(String inputStyle) {
        this.inputStyle = inputStyle;
    }

    public String getMenuColor() {
        return menuColor;
    }

    public void setMenuColor(String menuColor) {
        this.menuColor = menuColor;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public List<Layout> getLayouts() {
        return layouts;
    }

    public void setLayouts(List<Layout> layouts) {
        this.layouts = layouts;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public LinkedHashMap<String, Object> getCountries() {
        return countries;
    }

    public void setCountries(LinkedHashMap<String, Object> countries) {
        this.countries = countries;
    }

    public String getCaptchaLocal() {
        return captchaLocal;
    }

    public class Theme {

        private String name;

        private String file;

        private String color;

        public Theme() {
        }

        public Theme(String name, String file, String color) {
            this.name = name;
            this.file = file;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public class Layout {

        private String name;

        private String file;

        private String color;

        public Layout() {
        }

        public Layout(String name, String file, String color) {
            this.name = name;
            this.file = file;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}
