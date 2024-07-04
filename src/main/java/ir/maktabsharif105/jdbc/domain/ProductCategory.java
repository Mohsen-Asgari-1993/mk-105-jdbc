package ir.maktabsharif105.jdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory extends BaseEntity<Long> {

    private String title;

    private ProductCategory parent;

    private List<ProductCategory> children;

}
//  id   title   parent_id
//  1    mobile     null
//  2    books      null
//  3    usa        1
//  4    china      1
//  5    magazine   2
//  6    apple      3
//  7    honor      4

// [ProductCategory(
//              id = 1,
//              title = mobile,
//              children[
//                  (
//                  id=3,
//                  title=usa,
//                  children[
//                           (id=5 title=apple, children=null)
//                          ]
//                  ),
//                  (
//                  id=4,
//                  title=china,
//                  children[
//                           (id=7 title=honor, children=null)
//                          ]
//                  )
//                      ]
//              ),
// ProductCategory(
//              id = 2,
//              title = book,
//              children[
//                  (
//                  id=5,
//                  title=magazine,
//                  children=null
//              )
//]

/*create table product_category
(
id integer generated always as identity
constraint id
primary key,
title varchar not null,
parent_id integer
constraint product_category_product_category_id_fk
references product_category
);

create index product_category_parent_id_index
on product_category (parent_id);*/


/*
insert into product_category(title) values('mobile');
insert into product_category(title) values('books');
insert into product_category(title, parent_id) values('usa', 1);
insert into product_category(title, parent_id) values('china', 1);
insert into product_category(title, parent_id) values('apple', 3);
insert into product_category(title, parent_id) values('honor', 4);
insert into product_category(title, parent_id) values('magazine', 2);
* */