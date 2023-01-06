<h1>Java 11 | Selenium | TestNG | Maven | POM Project</h1>
<p>This is a sample Java 11 AdoptOpenJDK | Selenium WebDriver | Maven | TestNG project created in IntelliJ IDE, using Page Object Model and Generic Type.</p>
<p>Website <a href="https://www.99-bottles-of-beer.net/">https://www.99-bottles-of-beer.net/</a>&nbsp;was used to create functional, API, and UI tests.</p>
<p><a href="https://github.com/RedRoverSchool/AutomationQA_05/blob/main/.github/workflows/ci.yml">ci.yml</a> file was used for the GitHub workflow<br /><br /><a href="https://github.com/dorny/test-reporter">dorny/test-reporter@v1</a> was used to generate reports after each CI run<br /><br /></p>
<p><strong>pom.xml dependencies used:</strong></p>
<blockquote>
<pre>&lt;dependencies&gt;<br /><br />    &lt;dependency&gt;<br />        &lt;groupId&gt;org.testng&lt;/groupId&gt;<br />        &lt;artifactId&gt;testng&lt;/artifactId&gt;<br />        &lt;version&gt;7.6.1&lt;/version&gt;<br />    &lt;/dependency&gt;<br /><br />    &lt;dependency&gt;<br />        &lt;groupId&gt;org.seleniumhq.selenium&lt;/groupId&gt;<br />        &lt;artifactId&gt;selenium-java&lt;/artifactId&gt;<br />        &lt;version&gt;4.5.3&lt;/version&gt;<br />    &lt;/dependency&gt;<br /><br />    &lt;dependency&gt;<br />        &lt;groupId&gt;io.github.bonigarcia&lt;/groupId&gt;<br />        &lt;artifactId&gt;webdrivermanager&lt;/artifactId&gt;<br />        &lt;version&gt;5.3.0&lt;/version&gt;<br />    &lt;/dependency&gt;<br /><br />&lt;/dependencies&gt;</pre>
</blockquote>
<h1>API testing</h1>
<p>For testing requests and responses&nbsp;<strong>DevTools&nbsp;type property</strong> was used&nbsp;</p>
<blockquote>
<pre>&nbsp; DevTools devTools;<br /><br /></pre>
</blockquote>
<p><strong>setUpDevTool(WebDriver driver)&nbsp;</strong> method was created in the class CaptureNetworkTraffic &nbsp;to capture the traffic:</p>
<blockquote>
<pre><br />public&nbsp;CaptureNetworkTraffic setUpDevTool(WebDriver driver) {<br />&nbsp; &nbsp; &nbsp;devTools&nbsp;= ((ChromeDriver) driver).getDevTools();<br />&nbsp; &nbsp; &nbsp;devTools.createSession();<br />&nbsp; &nbsp; &nbsp;devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));<br />&nbsp;<br />&nbsp; &nbsp; &nbsp;return this;<br />&nbsp;}&nbsp;</pre>
</blockquote>
<p><strong>org.openqa.selenium.devtools.v106.network.Network</strong>&nbsp;was used for traffic interception.</p>
<p>Class&nbsp;<strong>HttpURLConnection</strong>&nbsp;was used to send direct API calls and check responses.</p>
<h1>Setup the project and execute tests locally</h1>
<p>1. Install IntelliJ IDE:<br /><a href="https://www.jetbrains.com/help/idea/installation-guide.html">https://www.jetbrains.com/help/idea/installation-guide.html</a></p>
<p>2. Copy the HTTPS project link from the GitHub repository:&nbsp;<br /><a href="https://github.com/RedRoverSchool/AutomationQA_05.git">https://github.com/RedRoverSchool/AutomationQA_05.git</a></p>
<p>3. Clone a repository from the main menu:&nbsp;<br /><a title="https://www.jetbrains.com/help/idea/cloning-repository.html#clone_project_from_main_screen" href="https://www.jetbrains.com/help/idea/cloning-repository.html#clone_project_from_main_screen">https://www.jetbrains.com/help/idea/cloning-repository.html#clone_project_from_main_screen</a></p>
<p>4. Go to the resources package, and copy local.properties.TEMPLATE file. Paste it to the resources package, and re-name the new file as&nbsp;local.properties</p>
<p>5. Execute test class or single test by opening the Test class, right-clicking on the green triangle, and choosing Run</p>
