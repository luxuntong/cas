/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jasig.cas.server.authentication;

import java.security.GeneralSecurityException;

/**
 * <p>
 * Determines that Credentials are valid. Password-based credentials may be
 * tested against an external LDAP, Kerberos, JDBC source. Certificates may be
 * checked against a list of CA's and do the usual chain validation.
 * Implementations must be parameter-ized with their sources of information.
 * <p>
 * Callers to this class should first call supports to determine if the
 * AuthenticationHandler can authenticate the credentials provided.
 *
 * @author Scott Battaglia
 * @version $Revision$ $Date$
 * @since 3.5
 */
public interface AuthenticationHandler {

    /**
     * Method to check if the handler knows how to handle the credentials
     * provided. It may be a simple check of the Credentials class or something
     * more complicated such as scanning the information contained in the
     * Credentials object.
     *
     * @param credentials The credentials to check.
     * @return true if the handler supports the Credentials, false otherwise.
     */
    boolean supports(Credential credentials);

    /**
     * Method to determine if the credentials supplied are valid.
     *
     * @param credentials The credentials to validate.
     * @return true if valid, return false otherwise.
     * @throws GeneralSecurityException An AuthenticationException can contain
     * details about why a particular authentication request failed.
     */
    boolean authenticate(Credential credentials) throws GeneralSecurityException;

    /**
     * Retrieves the name of the authentication handler.
     * <p>
     * CANNOT be null.  It should construct a name based on the toString() if a name has not been provided.
     *
     * @return the name that was set, or a toString representation.
     */
    String getName();
}