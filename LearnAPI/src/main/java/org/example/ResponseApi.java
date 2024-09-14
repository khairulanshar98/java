package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ResponseApi {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<FootballMatches> data;

    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    public void setAsteroids(List<Asteroid> asteroids) {
        this.asteroids = asteroids;
    }

    private List<Asteroid> asteroids;
    private PriorityQueue<Movies> priorityQueue;

    public ResponseApi() {
        this.page = 1;
        this.total = 0;
        data = new ArrayList<>();
        priorityQueue = new PriorityQueue<>();
        asteroids = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ResponseApi{" +
                "page=" + page +
                ", per_page=" + per_page +
                ", total=" + total +
                ", total_pages=" + total_pages +
                ", data.size=" + data.size() +
                ", data=" + data +
                ", priorityQueue.size=" + priorityQueue.size() +
                ", priorityQueue=" + priorityQueue +
                ", asteroids.size=" + asteroids.size() +
                ", asteroids=" + asteroids +
                '}';
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<FootballMatches> getData() {
        return data;
    }

    public void setData(List<FootballMatches> data) {
        this.data = data;
    }

    public PriorityQueue<Movies> getPriorityQueue() {
        return priorityQueue;
    }

    public void setPriorityQueue(PriorityQueue<Movies> priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

}
