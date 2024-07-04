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
