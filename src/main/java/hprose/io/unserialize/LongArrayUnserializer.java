/**********************************************************\
|                                                          |
|                          hprose                          |
|                                                          |
| Official WebSite: http://www.hprose.com/                 |
|                   http://www.hprose.org/                 |
|                                                          |
\**********************************************************/
/**********************************************************\
 *                                                        *
 * LongArrayUnserializer.java                             *
 *                                                        *
 * long array unserializer class for Java.                *
 *                                                        *
 * LastModified: Aug 3, 2016                              *
 * Author: Ma Bingyao <andot@hprose.com>                  *
 *                                                        *
\**********************************************************/

package hprose.io.unserialize;

import static hprose.io.HproseTags.TagEmpty;
import static hprose.io.HproseTags.TagList;
import java.io.IOException;
import java.lang.reflect.Type;

public final class LongArrayUnserializer extends BaseUnserializer<long[]> {

    public final static LongArrayUnserializer instance = new LongArrayUnserializer();

    @Override
    public long[] unserialize(Reader reader, int tag, Type type) throws IOException {
        if (tag == TagList) return ReferenceReader.readLongArray(reader);
        if (tag == TagEmpty) return new long[0];
        return super.unserialize(reader, tag, type);
    }

    public long[] read(Reader reader) throws IOException {
        return read(reader, long[].class);
    }
}
