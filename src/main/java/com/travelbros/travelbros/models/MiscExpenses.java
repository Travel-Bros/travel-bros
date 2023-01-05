package com.travelbros.travelbros.models;

import javax.persistence.*;

    @Entity
    @Table(name = "miscExpenses")
    public class MiscExpenses {

        //////////////////// Properties ////////////////////

        // Table Columns
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(nullable = false)
        private String title;

        @Column(nullable = false)
        private double cost;


//        // Instance Variables
//        @OneToOne(mappedBy = "tripBudget")
//        private Trip trip;

        // User joining
        @ManyToOne
        @JoinColumn(name = "budget_id")
        private Budget budget;

//////// GETTERS & SETTERS ////////
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public Budget getBudget() {
            return budget;
        }

        public void setBudget(Budget budget) {
            this.budget = budget;
        }


        //////// CONSTRUCTORS ////////
        public MiscExpenses() {}

        public MiscExpenses(long id, String title, double cost, Budget budget) {
            this.id = id;
            this.title = title;
            this.cost = cost;
            this.budget = budget;
        }
        public MiscExpenses(long id, String title, double cost) {
            this.id = id;
            this.title = title;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "MiscExpenses{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }
