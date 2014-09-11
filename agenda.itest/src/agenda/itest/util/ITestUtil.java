/*
 * Copyright (c) 2010-2013 The Amdatu Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package agenda.itest.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/**
 * Collection of generic itest utility methods.
 * 
 * @author <a href="mailto:amdatu-developers@amdatu.org">Amdatu Project Team</a>
 */
public class ITestUtil {

    /**
     * Creates a Properties object from a list of key-value pairs, e.g.
     * <pre>
     * properties("key", "value", "key2", "value2");
     * </pre>
     */
    public static Dictionary<String, Object> properties(String... values) {
        Dictionary<String, Object> props = new Hashtable<String, Object>();
        for (int i = 0; i < values.length; i += 2) {
            props.put(values[i], values[i + 1]);
        }
        return props;
    }

    /**
     * Retrieve the list if IPv4 addresses of the current environment excluding loopback devices.
     * 
     * @return list of addresses
     * @throws SocketException if lookup fails
     */
    public static List<Inet4Address> getInet4Addresses() throws SocketException {
        List<Inet4Address> addresses = new ArrayList<Inet4Address>();
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface networkInterface = (NetworkInterface) interfaces.nextElement();
            if (networkInterface.isLoopback()) {
                continue;
            }
            Enumeration<InetAddress> adresses = networkInterface.getInetAddresses();
            while (adresses.hasMoreElements()) {
                InetAddress ip = (InetAddress) adresses.nextElement();
                if (ip instanceof Inet4Address) {
                    addresses.add((Inet4Address) ip);
                }
            }
        }
        return addresses;
    }

    /**
     * Join an iterable of strings into a single using the specified delimiter.
     * 
     * @param iterable the subject
     * @param delimiter the delimiter
     * @return the join
     */
    public static String join(Iterable<? extends CharSequence> iterable, String delimiter) {
        Iterator<? extends CharSequence> iter = iterable.iterator();
        if (!iter.hasNext()) {
            return "";
        }
        StringBuilder buffer = new StringBuilder(iter.next());
        while (iter.hasNext()) {
            buffer.append(delimiter).append(iter.next());
        }
        return buffer.toString();
    }

    /**
     * Join an arry of strings into a single using the specified delimiter.
     * 
     * @param iterable the subject
     * @param delimiter the delimiter
     * @return the join
     */
    public static String join(String separator, String... parts) {
        StringBuilder builder = new StringBuilder();
        for (String part : parts) {
            if (builder.length() > 0) {
                builder.append(separator);
            }
            builder.append(part);
        }
        return builder.toString();
    }

    /**
     * Tests if two lists of string have the same members irrespective of order.
     * 
     * @param left the left
     * @param right the right
     * @return the result
     */
    public static boolean stringArrayEquals(String[] left, String[] right) {
        return stringListEquals(Arrays.asList(left), Arrays.asList(left));
    }

    /**
     * Tests if two arrays of strings have the same members irrespective of order.
     * 
     * @param left the left
     * @param right the right
     * @return the result
     */
    public static boolean stringListEquals(List<String> left, List<String> right) {
        if (left.size() != right.size()) {
            return false;
        }
        if (left.size() == 0) {
            return true;
        }
        List<String> copyOfLeft = new ArrayList<String>(left);
        List<String> copyOfRight = new ArrayList<String>(right);
        Collections.sort(copyOfLeft);
        Collections.sort(copyOfRight);
        for (int i = 0; i < left.size(); i++) {
            if (!copyOfLeft.get(i).equals(copyOfRight.get(i))) {
                return false;
            }
        }
        return true;
    }

    private ITestUtil() {
    }
}
