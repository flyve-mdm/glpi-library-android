/*
 *   Copyright © 2017 Teclib. All rights reserved.
 *
 *   This file is part of flyve-mdm-android
 *
 * flyve-mdm-android is a subproject of Flyve MDM. Flyve MDM is a mobile
 * device management software.
 *
 * Flyve MDM is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * Flyve MDM is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * ------------------------------------------------------------------------------
 * @author    Rafael Hernandez
 * @date      24/10/17
 * @copyright Copyright © 2017 Teclib. All rights reserved.
 * @license   GPLv3 https://www.gnu.org/licenses/gpl-3.0.html
 * @link      https://github.com/flyve-mdm/flyve-mdm-android
 * @link      https://flyve-mdm.com
 * ------------------------------------------------------------------------------
 */

package org.flyve.glpi.query;

import android.content.Context;

import org.flyve.glpi.R;

import java.util.HashMap;
import java.util.Map;

public class getAllItemQuery {

    private Boolean expandDropdowns;
    private Boolean getHateoas;
    private Boolean onlyId;
    private String range;
    private String sort;
    private String order;
    private String searchText;
    private Boolean isDeleted;
    private Context context;

    /**
     * Get all the parameters available to work with the all items endpoint
     * @param context
     */
    public getAllItemQuery(Context context) {
        this.context = context;
    }

    /**
     * Get a map with all the parameters available to work with the all items endpoint
     * @return Map<String, String> with the parameters selected
     */
    public Map<String, String> getQuery() {

        Map<String, String> map = new HashMap<>();

        if(expandDropdowns!=null) {
            map.put("expand_dropdowns", expandDropdowns.toString());
        }

        if(getHateoas!=null) {
            map.put("get_hateoas", getHateoas.toString());
        }

        if(onlyId!=null) {
            map.put("only_id", onlyId.toString());
        }

        if(range!=null) {
            map.put("range", range);
        }

        if(sort!=null) {
            map.put("sort", sort);
        }

        if(order!=null) {
            map.put("order", order);
        }

        if(searchText!=null) {
            map.put("searchText", searchText);
        }

        if(isDeleted!=null) {
            map.put("is_deleted", isDeleted.toString());
        }

        return map;
    }

    /**
     * (default: false): show dropdown name instead of id.
     * @param expandDropdowns boolean
     */
    public void setExpandDropdowns(Boolean expandDropdowns) {
        this.expandDropdowns = expandDropdowns;
    }

    /**
     * (default: true): Show relation of item in a links attribute.
     * @param getHateoas boolean
     */
    public void setGetHateoas(Boolean getHateoas) {
        this.getHateoas = getHateoas;
    }

    /**
     * (default: false): keep only id keys in returned data.
     * @param onlyId boolean
     */
    public void setOnlyId(Boolean onlyId) {
        this.onlyId = onlyId;
    }

    /**
     * (default: 0-50): a range with a couple of number for start and end of pagination
     * @param min
     * @param max
     */
    public void setRange(int min, int max) {
        if(max>=min) {
            throw new RuntimeException(context.getResources().getString(R.string.error_range));
        }

        this.range = min + "-" + max;
    }

    /**
     * (default 1): id of the searchoption to sort by.
     * @param sort int
     */
    public void setSort(int sort) {
        this.sort = String.valueOf(sort);
    }

    /**
     * (default ASC): ASC - Ascending sort / DESC Descending sort.
     * @param order Order type with ASC or DESC values
     */
    public void setOrder(Order order) {
        this.order = order.name();
    }

    /**
     * (default NULL): array of filters to pass on the query (with key = field and value the text to search)
     * @param searchText String
     */
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    /**
     * (default: false): Return deleted element.
     * @param deleted boolean
     */
    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    /**
     * Enum definition with sort order possibilities
     */
    public enum Order {
        DESC,
        ASC
    }
}
