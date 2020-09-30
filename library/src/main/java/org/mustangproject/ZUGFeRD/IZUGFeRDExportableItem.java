/** **********************************************************************
 *
 * Copyright 2018 Jochen Staerk
 *
 * Use is subject to license terms.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *********************************************************************** */
package org.mustangproject.ZUGFeRD;
/**
 * Mustangproject's ZUGFeRD implementation
 * Neccessary interface for ZUGFeRD exporter
 * Licensed under the APLv2
 * @date 2014-05-10
 * @version 1.2.0
 * @author jstaerk
 * */

import org.mustangproject.ZUGFeRD.model.TaxCategoryCodeTypeConstants;

import java.math.BigDecimal;

public interface IZUGFeRDExportableItem {

	IZUGFeRDExportableProduct getProduct();

	IZUGFeRDAllowanceCharge[] getItemAllowances();

	IZUGFeRDAllowanceCharge[] getItemCharges();


	/**
	 * The price of one item excl. taxes
	 *
	 * @return The price of one item excl. taxes
	 */
	BigDecimal getPrice();

	/**
	 * how many get billed
	 *
	 * @return the quantity of the item
	 */
	BigDecimal getQuantity();

	/**
	 * how many items units per price
	 * 
	 * @return item units per price
	 */
	default BigDecimal getBasisQuantity() {
		return BigDecimal.ONE.setScale(4);
	}

	default String getCategoryCode() {
		return TaxCategoryCodeTypeConstants.STANDARDRATE;
	}
	
	default String getAdditionalReferencedDocumentID() {
		return null;
	}

}