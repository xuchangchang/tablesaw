/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tech.tablesaw.columns.datetimes.filters;

import tech.tablesaw.api.DateTimeColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;
import tech.tablesaw.columns.ColumnReference;
import tech.tablesaw.filtering.ColumnFilter;
import tech.tablesaw.selection.Selection;

import java.time.LocalDateTime;

public class NotEqualTo extends ColumnFilter {

    private final LocalDateTime value;

    public NotEqualTo(ColumnReference reference, LocalDateTime value) {
        super(reference);
        this.value = value;
    }

    @Override
    public Selection apply(Table relation) {
        return apply(relation.column(columnReference().getColumnName()));
    }

    @Override
    public Selection apply(Column column) {
        DateTimeColumn dateColumn = (DateTimeColumn) column;
        return dateColumn.isEqualTo(value);
    }
}