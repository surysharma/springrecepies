package domain.service;

import domain.entity.Book;

public interface BookShop {
    public void purchase(Book... books);
}
